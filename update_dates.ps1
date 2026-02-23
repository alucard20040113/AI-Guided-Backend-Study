# PowerShell脚本：批量更新2025年1月文件为2026年1月

# 日期映射表
$dateMappings = @{
    "2025-01-01" = "2026-01-01"
    "2025-01-02" = "2026-01-02"
    "2025-01-05" = "2026-01-03"
    "2025-01-06" = "2026-01-04"
    "2025-01-07" = "2026-01-05"
    "2025-01-08" = "2026-01-06"
    "2025-01-09" = "2026-01-07"
    "2025-01-13" = "2026-01-10"
    "2025-01-14" = "2026-01-11"
}

# 处理每个文件
foreach ($oldDate in $dateMappings.Keys) {
    $newDate = $dateMappings[$oldDate]
    $oldPath = "sessions/$oldDate/session-notes.md"
    $newPath = "sessions/$newDate/session-notes.md"
    
    # 检查原文件是否存在
    if (Test-Path $oldPath) {
        Write-Host "处理: $oldDate -> $newDate"
        
        # 创建新目录
        New-Item -ItemType Directory -Path "sessions/$newDate" -Force | Out-Null
        
        # 读取文件内容并替换日期
        $content = Get-Content $oldPath -Raw
        $content = $content -replace "2025年1月${oldDate.Substring(8,2)}日", "2026年1月${newDate.Substring(8,2)}日"
        
        # 写入新文件
        $content | Out-File -FilePath $newPath -Encoding utf8
        
        Write-Host "✓ 完成: $oldPath -> $newPath"
    } else {
        Write-Host "⚠ 文件不存在: $oldPath"
    }
}

Write-Host "所有文件处理完成！"