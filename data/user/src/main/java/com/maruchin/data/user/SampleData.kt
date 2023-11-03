package com.maruchin.data.user

import java.net.URL

val sampleLoggedUser = User.LoggedIn(
    cardBarCode = URL("https://static01.nyt.com/images/2013/01/06/magazine/WMT-UPC/WMT-UPC-articleLarge.png?quality=75&auto=webp&disable=upscale"),
    clubLevel = ClubLevel.STANDARD,
)
