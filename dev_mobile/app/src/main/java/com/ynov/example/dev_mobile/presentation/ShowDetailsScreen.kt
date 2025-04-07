import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.draw.clip
import coil3.compose.AsyncImage
import com.ynov.example.dev_mobile.presentation.ShowDetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowDetailsScreen(
    showId: String,
    navController: NavController,
    viewModel: ShowDetailsViewModel = hiltViewModel()
) {
    val show by viewModel.state

    LaunchedEffect(showId) {
        viewModel.loadShowDetails(showId)
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        // TopAppBar stylisée
        TopAppBar(
            title = { Text(show?.name ?: "Details") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        show?.let {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Ombre légère
                shape = MaterialTheme.shapes.medium // Coins arrondis
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp) // Padding interne dans la carte
                        .verticalScroll(rememberScrollState()) // Défilement vertical
                ) {
                    AsyncImage(
                        model = it.imageUrl,
                        contentDescription = it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp) // Taille fixe pour l'image
                            .clip(MaterialTheme.shapes.medium) // Coins arrondis pour l'image
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.headlineMedium,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis // "..." si trop long
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it.description,
                        style = MaterialTheme.typography.bodyLarge, // Plus lisible
                        color = MaterialTheme.colorScheme.onSurfaceVariant // Couleur subtile
                    )
                }
            }
        }
    }
}