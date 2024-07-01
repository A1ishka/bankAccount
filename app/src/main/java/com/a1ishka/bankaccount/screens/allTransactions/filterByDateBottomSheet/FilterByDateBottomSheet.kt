@file:OptIn(ExperimentalMaterial3Api::class)

package com.a1ishka.bankaccount.screens.allTransactions.filterByDateBottomSheet

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a1ishka.bankaccount.R
import java.time.LocalDate.*
import java.util.Date
import java.util.Locale

@Composable
fun FilterByDateBottomSheet(onDismiss: () -> Unit) {
    val filterBottomSheetState = rememberModalBottomSheetState()

    val startDate = remember { mutableStateOf("") }
    val endDate = remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()
    val datePickerState =
        rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)

    var showDatePicker by remember {
        mutableStateOf(false)
    }
    var selectedDate by remember {
        mutableLongStateOf(calendar.timeInMillis)
    }
    var startDateSelected by remember {
        mutableStateOf(false)
    }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = filterBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        TopAppBar(
            title = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                ) {
                    Text(
                        text = stringResource(R.string.filter_by_date),
                        modifier = Modifier.align(Alignment.TopStart),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        )
        Column(
            modifier = Modifier
                .padding(15.dp)
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = stringResource(R.string.start_date),
                fontSize = 18.sp
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 20.dp),
                value = startDate.value,
                onValueChange = { startDate.value = it },
                singleLine = true,
                placeholder = {
                    Text(text = stringResource(R.string.select_start_date))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showDatePicker = true
                            startDateSelected = true
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                tint = MaterialTheme.colorScheme.outline,
                                contentDescription = "Calendar picker button"
                            )
                        }
                    )
                },
                textStyle = TextStyle(fontSize = 17.sp),
                shape = RoundedCornerShape(10.dp)
            )
            Text(
                text = stringResource(R.string.end_date),
                fontSize = 18.sp
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 20.dp),
                value = endDate.value,
                onValueChange = { endDate.value = it },
                singleLine = true,
                placeholder = {
                    Text(text = stringResource(R.string.select_end_date))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showDatePicker = true
                            startDateSelected = false
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                tint = MaterialTheme.colorScheme.outline,
                                contentDescription = "Calendar picker button"
                            )
                        }
                    )
                },
                textStyle = TextStyle(fontSize = 17.sp),
                shape = RoundedCornerShape(10.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(64, 156, 255, 255),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(stringResource(R.string.submit))
            }
        }

        if (showDatePicker) {
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

            DatePickerDialog(
                onDismissRequest = {
                    showDatePicker = false
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDatePicker = false
                        selectedDate = datePickerState.selectedDateMillis!!

                        val selectedDateString = formatter.format(Date(selectedDate))
                        if (startDateSelected) {
                            startDate.value = selectedDateString
                        } else {
                            endDate.value = selectedDateString
                        }
                    }) {
                        Text(text = stringResource(R.string.submit), color = Color.White)
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDatePicker = false
                    }) {
                        Text(text = stringResource(R.string.cancel), color = Color.Red)
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState
                )
            }
        }
    }
}