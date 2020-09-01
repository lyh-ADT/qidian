import re
import requests
import bs4
import json
import os
import time

def parseInfo(raw_content):
    bs = bs4.BeautifulSoup(raw_content, "lxml")
    intro = bs.select_one(".intro").text
    book_intro = bs.select_one(".book-intro").text.strip()
    raw_volume = bs.select(".volume li")
    word_count = 0
    volume = []
    for v in raw_volume:
        a = v.select_one("a")
        v_info = a["title"]
        c = int(re.search("章节字数：(\\d+)", v_info).group(1))
        word_count += c
        v_title = a.text
        volume.append({
            "info": v_info,
            "title": v_title
        })
    return {
        "intro": intro,
        "book_intro": book_intro,
        "word_count": word_count,
        "volume": volume
    }


"""
{
    "book_url": book_url,
    "cover_url": cover_url,
    "author": author,
    "title": title,
    "type": _type
}
"""

filenames = os.walk("./").__next__()[2]
infos = [i for i in filenames if i.endswith(".json")]
print(infos)

details = []
for info_name in infos:
    with open(info_name, "rt", encoding="utf8") as f:
        info = json.load(f)
    for book_info in info:
        raw_content = requests.get(book_info["book_url"]).content.decode("utf8")
        detail_info = parseInfo(raw_content)
        book_info.update(detail_info)
        details.append(book_info)
        print(book_info["title"])
        time.sleep(2)

with open("details.json", "wt", encoding="utf8") as f:
    json.dump(details, f)