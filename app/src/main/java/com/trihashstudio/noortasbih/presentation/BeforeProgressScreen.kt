package com.trihashstudio.noortasbih.presentation

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.trihashstudio.noortasbih.R
import com.trihashstudio.noortasbih.ui.theme.ArabicFont
import com.trihashstudio.noortasbih.ui.theme.Background

@Composable
fun BeforeProgressScreen(
    navController: NavHostController
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener { authResult ->
                    if (authResult.isSuccessful) {
                        // ✅ Login success, navigate to next screen
                        navController.navigate("home") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(context, "Google sign in failed", Toast.LENGTH_SHORT).show()
        }
    }

    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("137100923955-b46uc4smhd29rajegesjr8jgq73svnbd.apps.googleusercontent.com") // paste Web client ID here
        .requestEmail()
        .build()

    val googleSignInClient = GoogleSignIn.getClient(context, gso)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(22.dp)
    ) {
        Image(painter = painterResource(R.drawable.logo), contentDescription = null)
        Text(
            text = "Stay Connected to Your Dhikr Progress",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(R.drawable.progress_1),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(Modifier.height(40.dp))

        Spacer(Modifier.height(10.dp))
        Text(
            "Please log in to track your progress", style = TextStyle(
                fontSize = 32.sp,
                color = Color.White,
                fontFamily = ArabicFont
            )
        )
        Spacer(Modifier.height(15.dp))
    }
}
