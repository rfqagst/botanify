package com.example.botanify.data.local

import com.example.botanify.R

data class PlantData(
    val id: String,
    val name: String,
    val description: String,
    val image: Int,
)


val plantsData = listOf(
    PlantData(
        id = "1",
        name = "Flamingo Lily Flower",
        description = "Anthurium andraeanum is a flowering plant species in the family Araceae that",
        image = R.drawable.plantdata_flamingo
    ),
    PlantData(
        id = "2",
        name = "Palem",
        description = " Bentuk pohon palem sekilas mirip dengan pohon kelapa. Tidak hanya mirip, tumbuhan palem memang masih satu keluarga dengan pohon kelapa. Kemampuan adaptasi tanaman palem cukup hebat, karena mampu hidup di berbagai kawasan. Tanaman ini dapat tumbuh di tanah yang subur sampai gersang sekalipun.Pohon palem tumbuh di daerah yang beriklim tropis dan subtropis. Artinya tanaman palem dapat dikembangkan di Indonesia. Spesies pohon palem tersebar di penjuru dunia, ada sekitar 3.000 spesies.\nKemampuannya mampu beradaptasi di berbagai lingkungan, menjadikan tanaman palem sering dimanfaatkan sebagai tanaman hias. Tanaman ini juga perawatannya cukup mudah. Keindahan pohon ini juga dimanfaatkan masyarakat sebagai penghias pekarangan rumah.Ukuran tanaman ini sangat bervariatif, ada yang besar, sedang hingga kecil, tergantung pada jenis-jenisnya.Meskipun perawatannya cukup mudah, namun untuk menanam tanaman ini juga perlu beberapa teknik. Dari pembuatan lubang tanaman, jarak penanamannya dan harus menyesuaikan jenis pohon palem yang akan ditanam.",
        image = R.drawable.plantdata_palem
    ),
    PlantData(
        id = "3",
        name = "Melati",
        description = "Melati, melur, atau yasmin (Jasminum) merupakan tanaman bunga hias berupa perdu berbatang tegak yang hidup menahun. Melati merupakan genus dari semak dan tanaman merambat dalam keluarga zaitun (Oleaceae). Terdiri dari sekitar 200 spesies tumbuhan asli daerah beriklim tropis dan hangat dari Eurasia, Australasia dan Oseania, melati secara luas dibudidayakan untuk aroma khas bunganya yang harum. Di Indonesia, salah satu jenis melati telah dipilih menjadi puspa bangsa atau bunga simbol nasional yaitu melati putih (Jasminum sambac), karena bunga ini melambangkan kesucian dan kemurnian, serta dikaitkan dengan berbagai tradisi dari banyak suku di negara ini.\nBunga ini merupakan bagian yang tidak terpisahkan dari hiasan rambut pengantin perempuan dalam upacara perkawinan berbagai suku di Indonesia, terutama suku Jawa dan Sunda. Jenis lain yang juga populer adalah melati gambir (J. officinale). Di Indonesia nama melati dikenal oleh masyarakat di seluruh wilayah Nusantara. Nama-nama daerah untuk melati adalah Menuh (Bali), Meulu atau Riwat (Aceh),[2] Menyuru (Banda), Melur (Gayo dan Batak Karo), Manduru (Menado), Mundu (Bima dan Sumbawa) dan Manyora (Timor), Melati Salam (UMI), Malete (Madura) serta Beruq-beruq (Mandar).",
        image = R.drawable.plantdata_melati
    ),
    PlantData(
        id = "4",
        name = "Mawar",
        description = "Mawar atau ros (Rosa) adalah tumbuhan perdu, pohonnya berduri, bunganya berbau wangi dan berwarna indah, terdiri atas daun bunga yang bersusun; meliputi ratusan jenis, tumbuh tegak atau memanjat, batangnya berduri, bunganya beraneka warna, seperti merah, putih, merah jambu, merah tua, dan berbau harum. Mawar liar terdiri dari 100 spesies lebih, kebanyakan tumbuh di belahan bumi utara yang berudara sejuk. Spesies ini umumnya merupakan tanaman semak yang berduri atau tanaman memanjat yang tingginya bisa mencapai 2 sampai 5 meter. Walaupun jarang ditemui, tinggi tanaman mawar yang merambat di tanaman lain bisa mencapai 20 meter.\nSebagian besar spesies mempunyai daun yang panjangnya antara 5-15 cm dengan dua-dua berlawanan (pinnate). Daun majemuk yang tiap tangkai daun terdiri dari paling sedikit 3 atau 5 hingga 9 atau 13 anak daun dan daun penumpu (stipula) berbentuk lonjong, pertulangan menyirip, tepi tepi beringgit, meruncing pada ujung daun dan berduri pada batang yang dekat ke tanah. Mawar sebetulnya bukan tanaman tropis, sebagian besar spesies merontokkan seluruh daunnya dan hanya beberapa spesies yang ada di Asia Tenggara yang selalu berdaun hijau sepanjang tahun.",

        image = R.drawable.plantdata_mawar
    ),
    PlantData(
        id = "5",
        name = "Krisan",
        description = "Bunga krisan (Chrysanthemum), satu jenis tanaman berbunga dari suku Asteraceae yang biasa dinamai bunga potong atau bunga emas. Chrysos dalam bahasa Yunani berarti emas, sedangkan anthemon berarti bunga.Tampilan warna bunganya yang eksotik berkilauan membuat bunga ini kerap dijadikan bunga spesial pelengkap sebuah kado atau pada acara-acara formal tertentu.\nKrisan juga dapat melengkapi dekorasi tata ruang untuk pesta pernikahan  atau ulang tahun. Di Indonesia, bunga ini lebih dikenal dengan istilah bunga seruni. Di sejumlah Negara, tanaman berbunga ini juga dinamai bunga krisanium.Karena tampilannya yang indah, krisan diidentikkan dengan romantisme atau bunga cinta. Seorang pria yang ingin mengajak kekasihnya bertunangan, tak jarang dihaturkan dengan membawa bunga krisan.",
        image = R.drawable.plantdata_krisan
    ),
    PlantData(
        id = "6",
        name = "Keladi Hias",
        description = "Anthurium termasuk tanaman dari keluarga Araceae. Tanaman berdaun indah ini masih berkerabat dengan sejumlah tanaman hias populer semacam aglaonema, philodendron, keladi hias, dan alokasia. Dalam keluarga araceae, anthurium adalah genus dengan jumlah jenis terbanyak. Diperkirakan ada sekitar 1000 jenis anggota marga anthurium.\nTanaman ini termasuk jenis tanaman evergreen atau tidak mengenal masa dormansi. Dialam, biasanya tanaman ini hidup secara epifit dengan menempel di batang pohon. Dapat juga hidup secara terestrial di dasar hutan.\nDaya tarik utama dari anthurium adalah bentuk daunnya yang indah, unik, dan bervariasi. Daun umumnya berwarna hijau tua dengan urat dan tulang daun besar dan menonjol. Sehingga membuat sosok tanaman ini tampak kekar namun tetap memancarkan keanggunan tatkala dewasa. Tidak heran bila tanaman ini memiliki kesan mewah dan eksklusif. Dimasa lalu, anthurium banyak menjadi hiasan taman dan istana kerajaan-kerajaan di Jawa. Konon, dipuja sebagai tanaman para raja.",

        image = R.drawable.plantdata_keladihias
    ),
    PlantData(
        id = "7",
        name = "Kamboja Jepang",
        description = "Kamboja jepang atau adenium (Adenium) adalah spesies tanaman hias, batangnya besar, bagian bawahnya menyerupai umbi, batangnya tidak berkambium, akarnya dapat membesar menyerupai umbi, bentuk daunnya panjang ada yang lonjong, runcing, kecil, dan besar, warna bunganya bermacam-macam.\nBunga ini disebut juga dengan mawar padang pasir (desert rose). Karena berasal dari daerah kering, tanaman ini tumbuh lebih baik pada kondisi media yang kering dibanding terlalu basah. Disebut sebagai adenium karena salah satu tempat asal adenium adalah daerah Aden (Ibu kota Yaman).\nMasyarakat Indonesia menamakan adenium sebagai kamboja jepang, mungkin dikaitkan dengan stereotipe yang beredar. Contohnya buah-buahan yang besar biasa disebut sebagai Bangkok, sedangkan tanaman yang kecil-kecil biasa disebut Jepang. Oleh karena itu, jika dahulu kala sudah ada kamboja yang sosok tanamannya tinggi besar maka begitu ada tanaman yang sosoknya kecil tapi mirip kamboja, disebutlah sebagai kamboja jepang.",

        image = R.drawable.plantdata_kambojajepang
    ),
    PlantData(
        id = "8",
        name = "Herbras",
        description = "Herbras (Gerbera) adalah tanaman hias yang termasuk dalam keluarga Asteraceae. Herbras adalah tanaman semak yang hidup bertahun-tahun (perenial), daunnya berbentuk memanjang, berwarna hijau dengan pinggiran daun bergerigi besar.Gerbera diambil dari nama Traugott Gerber seorang dokter Jerman yang merupakan teman Carolus Linnaeus. Nama spesies Gerbera jamesonii (Barberton daisy) diambil dari nama kolektor tanaman bernama Robert Jameson yang menemukan tanaman ini di provinsi Transvaal, Afrika Selatan.\nHerbras terdiri dari sekitar 2.000 kultivar dengan bunga yang mempunyai bentuk beraneka ragam dan ukuran diameter antara 5–12 cm. Bunga Herbras memiliki bongkol (capitulum) besar yang merupakan pokok dari 2 lapis rangkaian daun mahkota (disebut ray floret) berbentuk panjang yang berwarna-warni menarik: oranye, kuning, merah jambu, merah, putih, pink salmon, dan ungu. Bagian bongkol juga terdiri dari susunan ratusan bunga kecil-kecil (trans floret dan disc floret) sehingga terlihat menyerupai satu bunga yang utuh. Pada bagian tengah bongkol kadang-kadang berwarna gelap. Pada bunga yang sama juga sering dijumpai perbedaan warna pada daun mahkota.",
        image = R.drawable.plantdata_herbrasgerbera
    ),
    PlantData(
        id = "9",
        name = "Hanjuang",
        description = "Hanjuang atau andong secara ilmiah dalam bahasa Latin dinamakan sebagai Cordyline fruticosa dan disinonimkan sebagai Cordyline terminalis. Secara internasional dalam bahasa Inggris tumbuhan ini dikenal dengan nama ti plant, bongbush, cabbage pal, palm lily atau ti palm. Di Inggris tanaman ini lebih populer dengan nama good luck plant atau tree of kings.Kata Cordell pada nama genusnya berasal dari bahasa Yunani dengan arti yang mengacu pada batang dan akar bawah tanahnya yang membesar (Cordyline Fruticosa NBATAT, 2023).\nSpesies ini dinamai oleh Linnaeus sebagai Convallaria fruticosa pada tahun 1754, sebagai Asparagus fruticosa pada tahun 1767 dan juga sebagai Dracaena terminalis pada tahun 1767. Dinamakan Cordyline ti oleh Schott pada tahun 1828 dan terakhir sebagai Cordylinefruticosa oleh Chevalier pada tahun 1919. Banyak sinonim lain yang telah diterapkan pada spesies ini dalam genera Cordyline, Dracaena dan Taetsia. Namun masih sering disebut sebagai C. terminalis (L.) Kunth, meskipun Daftar Tumbuhan (Plant List) menunjukkan bahwa nama ini sebenarnya tidak valid (Simpson, 2022).",
        image = R.drawable.plantdata_hanjuang
    ),
    PlantData(
        id = "10",
        name = "Dracaena",
        description = "DRACAENA merupakan kelompok tumbuhan yang anggotanya sangat beragam, termasuk dalam suku Asparagaceae. Kelompok tumbuhan ini memiliki perawakan pohon, perdu ataupun terna, daunnya sangat beragam bentuk dan warnanya serta memiliki bunga  majemuk yang tersusun dalam rangkaian tandan atau  malai.\nBunga tunggalnya memiliki  perhiasan berwarna kuning pucat kehijauan, berbentuk tabung, dan harum baunya. Sehingga istilah harum dalam bahasa ilmiahnya fragrans” disematkan sebagai nama penunjuk jenis pada salah satu jenisnya yaitu Dracaena fragrans.\nJenis tersebut berbatang kokoh dan berkayu, berwarna putih kecokelatan, dengan daun  lanset memanjang. Bunganya tersusun dalam rangkaian malai berwarna putih kotor, lembayung pucat jika mekar dan harum baunya.\nDalam Plant of the World Online disebutkan, bahwa jenis tersebut tumbuh di lahan kering daerah tropik dan berpotensi sebagai pembersih lingkungan, serta sebagai obat dan makanan. Namun masih diperlukan penelitian lebih lanjut untuk potensinya. Yang jelas, jenis ini sudah banyak ditanam di Indonesia sebagai tanaman hias.",

    image = R.drawable.plantdata_dracaena
    ),
)