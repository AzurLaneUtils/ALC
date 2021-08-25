# Affection System Implementation Document

## Definition

Affection is a value in the range of [0, 200]. Different values provide different bonus for *KAN-SEN*.

For different affection, the bonus it provides follow the following rules:

- if `0 < affection < 60.0`, *no* bouns provided.
- if `60.0 <= affection < 80.0`, *1%* bonus provided.
- if `80.0 <= affection < 100`, *3%* bonus provided.
- if `affection == 100`, *6%* bonus provided.
- if `100 <= affection < 200` with oath, *9%* bonus provided.
- if `affection == 200`, *12%* bonus provided.

## Implementation

**Type definition**

<pre style="font-family: Inconsolata">
<code style="color: #c27ba0">typealias</code> Affection = <code style="color: cyan">UInt</code><sup style="font-size: 9px"><a href="#comment-1">(1)</a></sup>
</pre>

**Implementation Details**

Separate the binaray number of *Affection* as 2 part(high 16 bit and low 16 bit). Then the first four bits in low 16 bits are used to indicate *bonus*, and the rest of low 16 bits are used to indicate affection number.

**Constant definition**

| name           | value | binaray(low16bit) |
| -------------- | ----- | ----------------- |
| `DISAPPOINTED` | 0H    | 0000 0000 0000 0000 |
| `STRANGER`     | 32H   | 0000 0000 0011 0010 |
| `FRIENDLY`     | 103CH | 0001 0000 0011 1100 |
| `CRUSH`        | 3050H | 0011 0000 0101 0000 |
| `LOVE`         | 6064H | 0110 0000 0110 0100 |
| `OATH`         | 9064H | 1001 0000 0110 0100 |
| `OATH200`      | C0C8H | 1100 0000 1100 1000 |

**Operators**

Get the affection value.
```kotlin
fun getAffection(a: Affection): Int
```

Get the bonus provided.
```kotlin
fun getBonus(a: Affection): Double
```
___
<p id="comment-1" style="font-size: 11px">(1) Use `UInt` not `Ushort` is because kotlin does not support direct right shift.</p>
