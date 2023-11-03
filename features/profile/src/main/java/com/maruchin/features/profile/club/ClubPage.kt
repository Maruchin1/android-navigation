package com.maruchin.features.profile.club

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.maruchin.data.user.ClubLevel
import com.maruchin.data.user.User
import com.maruchin.data.user.sampleLoggedUser
import java.net.URL

@Composable
internal fun ClubPage(onOpenPurchaseHistory: () -> Unit, onOpenFindOutMore: () -> Unit) {
    val viewModel: ClubViewModel = hiltViewModel()
    val user by viewModel.user.collectAsState()

    if (user == null) return

    ClubPage(
        user = user!!,
        onOpenPurchaseHistory = onOpenPurchaseHistory,
        onOpenFindOutMore = onOpenFindOutMore
    )
}

@Composable
internal fun ClubPage(
    user: User.LoggedIn,
    onOpenPurchaseHistory: () -> Unit,
    onOpenFindOutMore: () -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        BardCodeCard(barCode = user.cardBarCode)
        ClubLevelCard(clubLevel = user.clubLevel, onOpenPurchaseHistory = onOpenPurchaseHistory)
        BenefitsListCard(onOpenFindOutMore = onOpenFindOutMore)
    }
}

@Composable
private fun BardCodeCard(barCode: URL) {
    OutlinedCard {
        AsyncImage(
            model = barCode.toString(),
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(16f / 9f)
                .padding(16.dp)
        )
    }
}

@Composable
private fun ClubLevelCard(clubLevel: ClubLevel, onOpenPurchaseHistory: () -> Unit) {
    OutlinedCard {
        Column {
            ClubLevelAndBalance(clubLevel = clubLevel)
            Divider()
            Timeline()
            TimelineLabels()
            Divider()
            PurchaseHistoryButton(onClick = onOpenPurchaseHistory)
        }
    }
}

@Composable
private fun ClubLevelAndBalance(clubLevel: ClubLevel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ClubLevelLabel(clubLevel = clubLevel)
        UserBalance()
    }
}

@Composable
private fun ClubLevelLabel(clubLevel: ClubLevel) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = clubLevel.toString(),
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
private fun UserBalance() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "0 zł", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "SALDO",
            style = MaterialTheme.typography.labelMedium,
            color = Color.Gray
        )
    }
}

@Composable
private fun Timeline() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        TimelineLine()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimelineBullet(color = MaterialTheme.colorScheme.primary)
            TimelineBullet()
            TimelineBullet()
        }
    }
}

@Composable
private fun TimelineLabels() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ClubLevelBalance(
            balance = "0 zł",
            clubLevel = ClubLevel.STANDARD,
            alignment = Alignment.Start,
        )
        ClubLevelBalance(
            balance = "400 zł",
            clubLevel = ClubLevel.SILVER,
            alignment = Alignment.CenterHorizontally,
        )
        ClubLevelBalance(
            balance = "800 zł",
            clubLevel = ClubLevel.GOLD,
            alignment = Alignment.End,
        )
    }
}

@Composable
private fun TimelineLine() {
    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(6.dp)
            .fillMaxWidth()
            .background(Color.LightGray)
    )
}

@Composable
private fun TimelineBullet(color: Color = Color.LightGray) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
    )
}

@Composable
private fun ClubLevelBalance(
    balance: String,
    clubLevel: ClubLevel,
    alignment: Alignment.Horizontal
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = alignment
    ) {
        Text(text = balance, style = MaterialTheme.typography.labelLarge)
        Text(
            text = clubLevel.toString(),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )
    }
}

@Composable
private fun PurchaseHistoryButton(onClick: () -> Unit) {
    Text(
        text = "Purchase history",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun BenefitsListCard(onOpenFindOutMore: () -> Unit) {
    OutlinedCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BenefitsListTitle()
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
            BulletItem(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit")
        }
        Divider()
        FindOutMoreButton(onClick = onOpenFindOutMore)
    }
}

@Composable
private fun BenefitsListTitle() {
    Text(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun BulletItem(text: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.LightGray)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
private fun FindOutMoreButton(onClick: () -> Unit) {
    Text(
        text = "Find out more",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ClubScreenPreview() {
    MaterialTheme {
        ClubPage(user = sampleLoggedUser, onOpenPurchaseHistory = {}, onOpenFindOutMore = {})
    }
}