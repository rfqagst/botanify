package com.example.botanify.data.dummy

import com.example.botanify.R

data class MyPlantData (
    val id : String,
    val name : String,
    val schedule : String,
    val image : Int,
    val description : String
)

val myplantsData = listOf(
    MyPlantData(
        id = "1",
        name = "Aglaonema",
        schedule = "Senin, 20 April",
        image = R.drawable.ts_aglaonema,
        description = "Aglaonema termasuk jenis-jenis tanaman hias yang tidak pernah surut penggemarnya. Aglaonema termasuk tanaman hias jenis talas-talasan. Ada banyak jenis aglaonema dengan beragam corak, warna, dan ukuran. Harga aglaonema pun beragam sesuai dengan jenisnya, mulai dari RP 30 ribu sampai jutaan rupiah."
    ),
    MyPlantData(
        id = "2",
        name = "Peperomia",
        schedule = "Selasa, 21 April",
        image = R.drawable.ts_peperomia,
        description = "Peperomia termasuk jenis tanaman hias yang dikenal sebagai tanaman abadi. Tanaman in memiliki daun tumpul tebal dengan tekstur seperti karet. Lebih dari 1.500 spesies, dengan jenis yang umum sering ditanam sebagai tanaman hias berkelompok. Harga Peperomia cukup terjangkau mulai dari Rp 20 ribu sampai ratusan ribu."
    ),
    MyPlantData(
        id = "3",
        name = "Calathea",
        schedule = "Rabu, 22 April",
        image = R.drawable.ts_calathea,
        description = "Calathea dikenal sebagai jenis-jenis tanaman hias dengan dengan daun lonjong yang ditandai dengan garis dalam rangkaian warna yang memesona. Karena garis-garis dan urat tanaman yang menarik perhatian, mereka sering dikenal dengan julukan seperti tanaman zebra, tanaman merak, atau tanaman ular berbisa. Harga tanaman Calathea beragam sesuai dengan jenisnya. Tanaman ini bisa ditemukan dengan garga mulai dari Rp 20 ribu sampai ratusan ribu rupiah."
    ),
    MyPlantData(
        id = "4",
        name = "Alocasia",
        schedule = "Kamis, 23 April",
        image = R.drawable.ts_alocasia,
        description = "Alocasia merupakan jenis-jenis tanaman hias tropis yang masih berkerabat dengan aglaonema, keladi, dan anthurium. Alocasia terkenal dengan bentuk yang unik. Ada lebih dari 70 jenia Alocasia. Jenis Alocasia yang kini sedang hits adalah Alocasia Baginda Silver Dragon. Jenis lainnya seperti Alocasia Melo, Alocasia Wentii, Alocasia Longiloba, Alocasia Micholtziana ‘Frydek’, dan Alocasia Amazonia ‘Polly’ juga banyak dicari para penggemar tanaman hias. Harga alocasia juga cukup terjangkau mulai dari Rp 25 ribu sampai ratusan ribu."
    ),
    MyPlantData(
        id = "5",
        name = "Homalomena",
        schedule = "Jumat, 24 April",
        image = R.drawable.ts_homalomena,
        description = "Homalomena termasuk tanaman hias yang juga masih berkerabat dengan aglaonema dan keladi. Tanaman ini dikenal karena dedaunannya yang besar, berkilau dan perawatan yang relatif mudah. Daun Homalomena kebanyakan berbentuk hati atau mata panah. Inilah membuatnya mendapatkan julukan ratu hati atau tanaman perisai."
    ),
    MyPlantData(
        id = "6",
        name = "Monstera",
        schedule = "Selasa, 21 April",
        image = R.drawable.ts_monstera,
        description = "Jenis-jenis tanaman hias Monstera juga tengah digemari banyak orang. Nama monstera diambil dari bahasa latin monstrou yang artinya tidak normal karena memang bentuk daunnya yang berlubang. Meski kebanyakan memiliki ciri khas berlubang, ada juga yang tidak berlubang. Tanaman dengan ukuran daun yang besar dan lebar ini, sering digunakan untuk dekorasi rumah atau bahkan properti foto karena tanaman ini memiliki nilai estetik. Diketahui tanaman jenis philodendron ini masuk dalam keluarga talas-talasan (Araceae)."
    ),
    MyPlantData(
        id = "7",
        name = "Philodendron",
        schedule = "Senin, 20 April",
        image = R.drawable.ts_philodendron,
        description = "Philodendron menjadi primadona sebagai tanaman indoor maupun interior ruangan. Tanaman ini memiliki banyak ragam dan eksotis, sekitar 450 varietas. Beberapa spesies ada yang tumbuh merambat dan ada pula yang tumbuh semak. Kesamaan dari semua jenis philodendron adalah kemampuannya yang bisa tumbuh di berbagai kondisi lingkungan. Masing-masing jenis memiliki ciri khas fisik yang berbeda-beda, baik dari bentuk, ukuran, maupun warna daunnya."
    ),
)
