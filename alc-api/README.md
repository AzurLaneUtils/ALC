# Module `alc-api`

该模块内部定义了游戏结构和alc数据计算的实现。

## Structure
- `org.alu.alc.*`: 该包下定义了ALC对外的api
- `org.alu.alc.internal*`: 该包下定义了ALC的内部实现
  - `.equ`: 装备系统的实现
  - `.skill`: 技能系统的实现
  - `.ship`: 舰船系统的实现

其中，`Fleet.kt`和`Chapter.kt`是对角色在*舰队中*和*关卡内*中的数据进行计算的实现。

## documents
关于该模块的文档，参阅: [alc-api-doc](../docs/alc-api-doc.md)
