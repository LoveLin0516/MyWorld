package com.example.myworld

import java.util.regex.Pattern

/**
 * Created by zhuqianglong@bigo.sg on 2020/12/29
 * Description:
 */


fun main(){

    //    val URI = 4144 shl 8 or 20
//    val proc =URI shr 8
//    println("URI---->$URI")
//    println("proc---->$proc")



    val mailList = listOf<String>("АаиЯК@yandex.ru", "ззз@yandex.ru",
        "kdkelldldldşrşrodııdıd@outlook.com", "احبك@gmail.com",
        "жан@mail.ru", "топатмчоотвсл@mail.ru", "mahmoodsyed8899@gmail.com",
        "ا@gmail.com", "łôłëŝf@gmail.com", "сс@gmail.com","тиапттмр@mail.ru",
        "ззз@yandex.ru","ሰ@gmail.com", "\uD835\uDC82\uD835\uDC8A\uD835\uDC8F\uD835\uDC82\uD835\uDC8F\uD835\uDC82\uD835\uDC8F\uD835\uDC82271@gmail.com",
        "ангелина@mail.ru")

    val mailList2 = listOf<String>("АаиЯК@АаиЯК.ru", "ззз@ззз.ззз",
        "kdkelldldldşrşrodııdıd@ııdıd.ııdıd")


    val mailList3 = listOf<String>(
        "a_b_ccd_123@123.ru",
        "ab123s_qqq_123ccd_123@xyz.ru",
        "xyzcc_78901011223@1c2c3c.ru23",
        "xyzcc_78901011223@1c2c3c.ru2333",
        "a_b_ccd_123@123.163",
        "@@@@@163.ccccc",
        "123132123",
        "123132123@.com",
        "123132123@__.com",
        "1231...32123@__.com",
        "1231。。。32123@__.com",
        "_______@173.comm",
        "_______@@173.comm",
        "___%____@173.comm",
        "___*____@173.comm",
        "___()____@173.comm",
        "___123sgh____@173.comm",
        "___123sgh____@ssssssssssss.ssss",
        "hahah#$@$.163",
        "a_b#_ccd_123@123.163"
    )

//    val p: Pattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
//    mailList3.forEach {
//        val matcher = p.matcher(it)
////        Log.d("ansen", "$it----->${matcher.find()}")
//        println("$it----->${matcher.find()}")
//    }

}