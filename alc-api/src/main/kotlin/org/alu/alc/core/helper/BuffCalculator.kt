package org.alu.alc.core.helper

import kotlin.collections.ArrayList
import org.alu.alc.core.Fleet

/**
 * 本类负责计算已经处理之后的buff
 * */
class BuffCalculator(
    /** 技能优先级的最大值 */
    var maximumTypes: Int = 1
) {
    /**
     * 将几个零散的[Buff]示例的值合并
     * */
    fun mergeBuffs(vararg buffs: Buff): Buff {
        val dList = ArrayList<Double>()
        val iList = ArrayList<Int>()
        for (buff in buffs) {
            dList.addAll(buff.effects)
            iList.addAll(buff.priorities)
        }
        return Buff(dList, iList)
    }

    /**
     * 获取某一优先级的总buff
     * */
    fun actualBuffOfThisKind(p: Int, bs: Buff): Double {
        var actualBuff = 0.0
        for ((index, bp) in bs.priorities.withIndex()) {
            if (bp == p) {
                actualBuff += bs.effects[index]
            }
        }
        return actualBuff
    }

    /**
     * 获取实际的buff
     *
     * 传入的buff必须是经过[Fleet.getBuffOfTypeToAffectObject]处理后的buff，因为此类没有处理buff的能力
     *
     * Fleet的ships元素时刻面临着被更新的情况，因此使用一个外部的Warship参数是危险的，这很可能导致异常
     * */
    fun actualBuffOfOne(buff: Buff): Double {
        var p = 0
        var actualBuff = 1.0
        while (p <= this.maximumTypes) {
            actualBuff *= (1 + actualBuffOfThisKind(p, buff))
            ++p
        }
        return actualBuff
    }
}
