import requests
import re
import bs4
import json

def parseBookInfo(raw_content):
    bs = bs4.BeautifulSoup(raw_content, "lxml")

    book_list = bs.select(".all-book-list li")
    print(len(book_list))

    infos = []
    for raw_book in book_list:
        book_url = "http:" + raw_book.select_one("h4 a")["href"]
        cover_url = "http:" + raw_book.select_one("img")["src"]
        author = raw_book.select_one(".name").text
        title = raw_book.select_one("h4").text
        _type = raw_book.select_one(".go-sub-type").text
        infos.append({
            "book_url": book_url,
            "cover_url": cover_url,
            "author": author,
            "title": title,
            "type": _type
        })
    return infos


url = "https://www.qidian.com/all?chanId=7&pageSize=20&siteid=1&pubflag=0&hiddenField=0&page={}"

page = 5

all_info = []
for page_index in range(1, page+1):
    print(page_index)
    raw_content = requests.get(url.format(page_index)).content.decode("utf8")
    infos = parseBookInfo(raw_content)
    all_info.extend(infos)

with open("7.json", "wt", encoding="utf8") as f:
    json.dump(all_info, f)