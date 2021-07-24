# alc-api document

## .alc.Fleet
`data class Fleet`是用于计算某一角色角色在舰队中数据的类。

该类含有以下构造器:
| parameters | characteristic | desc |
| ---------- | -------------- | ---- |
| Boolean | major | 构造一个空Fleet，如果参数是true，则构造一个潜艇舰队 |
| Boolean, vararg Warship | minor | 用指定Warship构造舰队，如果传入的船的数量和舰队状态不符合则抛出异常 |

该类含有以下字段:
| name | type | desc | access |
| ---- | ---- | ---- | ------ |
| ships | val MutableList\<Warship\> | 舰队存在的舰船 | private |

该类含有以下公共方法:
| name | parameters | return | desc |
| ---- | ---------- | ------ | ---- |
| getShip | Int | ships\[n\] | 获取指定位置的ship |
| putShip | Int, Warship | Unit | 将ship放入指定位置 |
| getBuff | BonusType, ShipType, Faction | DoubleArray | 获取目标类型的作用buff集合 |
| getBuff | BonusType, Int | DoubleArray | 获取目标类型，作用于某一个舰船上的buff |
