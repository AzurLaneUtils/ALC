## \[alc.proposals.p0001\]
<p style="text-align: right">
last update: 2020-2-14 <br/>
author(s): Xymul <br/>
</p>

### 实现要求 \[alc.proposals.p0001.implementation_requests\]

#### 接口实现要求 \[alc.proposals.p0001.implementation_requests.interfaces\]
- 所有对于Weapon的实现必须对**Weapon.applicability**做出特化
- 所有对于Warship的实现必须对**Warship.shipType**做出特化，
并对武器、装备插槽的setter进行特化
- 所有对于Type的实现必须在Type内部
- 对于Equipment的实现: 待定