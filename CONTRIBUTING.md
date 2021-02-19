## CONTRIBUTING

> 在为本项目做出贡献前，您需要确保您会使用kotlin语言

### 项目相关
- 项目支持maven构建(未来会加入对gradle的支持)
- 项目基于kotlin1.4.20进行开发，运行坏境为openjdk15
- 项目分为两个模块:Client、Core

### 分支
- v0.x、v1.x等代表版本分支，这些分支用于记录该版本的最后稳定更新
- develop分支是供您开发的，请基于此分支开发

### 如何贡献?
- 优化代码
- 添加新特性
  - 在添加新特性前，请以markdown/html形式在/proposals目录下添加您的提案,
    或直接与开发者沟通
  - 提案模板: [proposal.template](./docs/proposal.template.md)
- 解决issues中的问题

### 注意事项
- 尽量不要引用新库
- 遵守kotlin编码规范。如果您使用idea进行开发，那么请将项目的CodeStyle设置为**Kotlin style guide**,
并且在提交前格式化代码。