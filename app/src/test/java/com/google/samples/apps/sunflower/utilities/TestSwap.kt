package com.google.samples.apps.sunflower.utilities

import org.junit.Test

class TestSwap {

    @Test
    fun TestSwap() {

        var temp = "" //temp
        var a5 = "NBH"
        var a1 = "HVV"
        var a2 = "HNK"
        var a3 = "TPA"
        var a4 = "TPQ"


        for (j in 0 until 5) { //Tuan
            println("------------> Next ${j} <---------------")
            temp = a5
            a5 = a4
            a4 = a3
            a3 = a2
            a2 = a1
            a1 = a5
            a1 = temp
            for (i in 0 until 4) {
                println("a1: ${a1} |a2: ${a2} | a3: ${a3} |a4: ${a4} |a5: ${a5} |temp ${temp}")
            }
        }
    }
}