"""
{
    "book_url": book_url,
    "cover_url": cover_url,
    "author": author,
    "title": title,
    "type": _type,
    "intro": intro,
    "book_intro": book_intro,
    "word_count": word_count,
    "volume": {
        "info": v_info,
        "title": v_title
    }
}
"""

import json


def parseDetails(details):
    types = set([b["type"] for b in details])
    print(types)
    types = list(types)
    types_sql = [f"insert into book_type values(0, '{t}');" for t in types]

    books_sql = []
    for b in details:
        sql = f"""insert into book values(0, '{b["title"]}', '{b["author"]}', '{b["intro"]}', '{b["book_intro"]}', '{b["cover_url"]}', '{types.index(b["type"]) + 1}');"""
        books_sql.append(sql)

    return types_sql, books_sql

with open("details.json", "rt", encoding="utf8") as f:
    details = json.load(f)
types_sql, books_sql = parseDetails(details)

with open("books.sql", "wt", encoding="utf8") as f:
    f.writelines([i+"\n" for i in types_sql])
    f.write("\n\n")
    f.writelines([i+"\n" for i in books_sql])