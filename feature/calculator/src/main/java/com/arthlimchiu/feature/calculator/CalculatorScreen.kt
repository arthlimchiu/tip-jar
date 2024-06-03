package com.arthlimchiu.feature.calculator

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arthlimchiu.core.ui.components.TipJarButton
import com.arthlimchiu.core.ui.theme.TipJarTheme
import com.arthlimchiu.feature.calculator.ext.createImageFile
import com.arthlimchiu.feature.calculator.ui.AmountSection
import com.arthlimchiu.feature.calculator.ui.PeopleCountSection
import com.arthlimchiu.feature.calculator.ui.TakePhotoSection
import com.arthlimchiu.feature.calculator.ui.TipBreakdownSection
import com.arthlimchiu.feature.calculator.ui.TipPercentSection
import com.arthlimchiu.feature.calculator.ui.components.TopBar
import kotlinx.coroutines.launch

@Composable
internal fun CalculatorRoute(
    viewModel: CalculatorViewModel = hiltViewModel(),
    onPaymentsHistoryClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var imageUri by remember { mutableStateOf(Uri.EMPTY) }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            viewModel.savePayment(imgPath = imageUri.toString())
            onPaymentsHistoryClick()
        } else {
            scope.launch { snackBarHostState.showSnackbar("Failed to save photo") }
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            val file = context.createImageFile()
            imageUri = FileProvider.getUriForFile(context, "com.arthlimchiu.tipjar.provider", file)
            cameraLauncher.launch(imageUri)
        } else {
            scope.launch {
                snackBarHostState.showSnackbar("Permission denied")
            }
        }
    }

    CalculatorScreen(
        amount = uiState.amount,
        onAmountChange = { amount -> viewModel.onAmountChange(amount) },
        numOfPeople = uiState.numOfPeople,
        onNumOfPeopleChange = { numOfPeople -> viewModel.onNumOfPeopleChange(numOfPeople) },
        tipPercentage = uiState.tipPercentage,
        onTipPercentageChange = { tipPercentage -> viewModel.onTipPercentageChange(tipPercentage) },
        totalTip = uiState.totalTip,
        tipPerPerson = uiState.tipPerPerson,
        takePhoto = uiState.takePhoto,
        onTakePhotoChecked = { takePhoto -> viewModel.onTakePhotoChecked(takePhoto) },
        onSavePaymentClick = {
            if (uiState.takePhoto) {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            } else {
                viewModel.savePayment()
                onPaymentsHistoryClick()
            }
        },
        onPaymentsHistoryClick = onPaymentsHistoryClick,
        snackBarHostState = snackBarHostState
    )
}

@Composable
internal fun CalculatorScreen(
    amount: String,
    onAmountChange: (String) -> Unit,
    numOfPeople: Int,
    onNumOfPeopleChange: (Int) -> Unit,
    tipPercentage: String,
    onTipPercentageChange: (String) -> Unit,
    totalTip: String,
    tipPerPerson: String,
    takePhoto: Boolean,
    onTakePhotoChecked: (Boolean) -> Unit,
    onSavePaymentClick: () -> Unit,
    onPaymentsHistoryClick: () -> Unit,
    snackBarHostState: SnackbarHostState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar(onPaymentsHistoryClick = onPaymentsHistoryClick) },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            AmountSection(
                amount = amount,
                onAmountChange = onAmountChange,
                modifier = Modifier.fillMaxWidth()
            )
            PeopleCountSection(
                numOfPeople = numOfPeople,
                onNumOfPeopleChange = onNumOfPeopleChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipPercentSection(
                tipPercentage = tipPercentage,
                onTipPercentageChange = onTipPercentageChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TipBreakdownSection(
                totalTip = totalTip,
                tipPerPerson = tipPerPerson,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            )
            TakePhotoSection(
                takePhoto = takePhoto,
                onTakePhotoChecked = onTakePhotoChecked,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 72.dp)
            )
            TipJarButton(
                text = "Save Payment",
                onClick = onSavePaymentClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                enabled = amount.isNotBlank()
            )
        }
    }
}

@Preview
@Composable
internal fun CalculatorScreenPreview() {
    TipJarTheme {
        Surface {
            CalculatorScreen(
                amount = "",
                onAmountChange = {},
                numOfPeople = 0,
                onNumOfPeopleChange = {},
                tipPercentage = "",
                onTipPercentageChange = {},
                totalTip = "",
                tipPerPerson = "",
                takePhoto = true,
                onTakePhotoChecked = {},
                onSavePaymentClick = {},
                onPaymentsHistoryClick = {},
                snackBarHostState = SnackbarHostState()
            )
        }
    }
}
