#!/usr/bin/env python3
# 批量修改2025年1月文件为2026年1月

import os
import re

# 日期映射表
date_mappings = {
    "2025-01-01": "2026-01-01",
    "2025-01-02": "2026-01-02", 
    "2025-01-05": "2026-01-03",
    "2025-01-06": "2026-01-04",
    "2025-01-07": "2026-01-05",
    "2025-01-08": "2026-01-06",
    "2025-01-09": "2026-01-07",
    "2025-01-13": "2026-01-10",
    "2025-01-14": "2026-01-11"
}

base_path = "sessions"

for old_date, new_date in date_mappings.items():
    old_file = os.path.join(base_path, old_date, "session-notes.md")
    new_file = os.path.join(base_path, new_date, "session-notes.md")
    
    if os.path.exists(old_file):
        print(f"处理: {old_date} -> {new_date}")
        
        # 创建新目录
        os.makedirs(os.path.dirname(new_file), exist_ok=True)
        
        # 读取文件内容
        with open(old_file, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # 替换日期
        old_day = old_date[-2:]
        new_day = new_date[-2:]
        content = content.replace(f"2025年1月{old_day}日", f"2026年1月{new_day}日")
        
        # 写入新文件
        with open(new_file, 'w', encoding='utf-8') as f:
            f.write(content)
        
        print(f"✓ 完成: {old_file} -> {new_file}")
    else:
        print(f"⚠ 文件不存在: {old_file}")

print("所有文件处理完成！")