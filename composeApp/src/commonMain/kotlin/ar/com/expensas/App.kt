package ar.com.expensas


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.expensas.data.TitleTopBarTypes
import ar.com.expensas.navigation.Navigator
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator


@Composable
fun App() {
    PreComposeApp {
        AppTheme {
            val colors = getColorsTheme()
            val navigator = rememberNavigator()
            val titleTopBar = getTitleTopAppBar(navigator)
            val isEditOrAddExpenses = titleTopBar != TitleTopBarTypes.DASHBOARD.value
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(title = {
                        Text(
                            text = titleTopBar, fontSize = 25.sp, color = colors.textColor
                        )
                    }, navigationIcon = {
                        if (isEditOrAddExpenses) {
                            IconButton(onClick = {
                                navigator.popBackStack()
                            }) {
                                Icon(
                                    modifier = Modifier.padding(start = 16.dp),
                                    imageVector = Icons.Default.ArrowBackIosNew,
                                    tint = colors.textColor, contentDescription = "Flecha back"
                                )
                            }
                        } else {
                            Icon(
                                modifier = Modifier.padding(start = 16.dp),
                                imageVector = Icons.Default.Apps,
                                tint = colors.textColor,
                                contentDescription = "Dashboard icon"
                            )
                        }
                    },
                        backgroundColor = colors.backgroundColor
                    )
                }, floatingActionButton = {
                    if (!isEditOrAddExpenses) {
                        FloatingActionButton(
                            modifier = Modifier.padding(8.dp),
                            onClick = { navigator.navigate("/addExpenses") },
                            shape = RoundedCornerShape(50),
                            backgroundColor = colors.addIconColor,
                            contentColor = colors.white

                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                tint = colors.white,
                                contentDescription = "Floating Add Icon"
                            )
                        }
                    }
                }
            ) {
                Navigator(navigator)
            }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    var titleTopBar = TitleTopBarTypes.DASHBOARD
    val isOnAddExpenses =
        navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpenses/{id}?")
    if (isOnAddExpenses) {
        titleTopBar = TitleTopBarTypes.ADD
    }
    val isOnEditExpenses = navigator.currentEntry.collectAsState(null).value?.path<Long>("id")
    isOnEditExpenses?.let {
        titleTopBar = TitleTopBarTypes.EDIT
    }
    return titleTopBar.value
}