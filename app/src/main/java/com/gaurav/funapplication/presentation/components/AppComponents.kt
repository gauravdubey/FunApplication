package com.gaurav.funapplication.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gaurav.funapplication.R
import com.gaurav.funapplication.data.home.NavigationItems
import com.gaurav.funapplication.presentation.theme.bgColor
import com.gaurav.funapplication.presentation.theme.colorGray
import com.gaurav.funapplication.presentation.theme.colorPrimary
import com.gaurav.funapplication.presentation.theme.colorSecondary
import com.gaurav.funapplication.presentation.theme.colorText
import com.gaurav.funapplication.presentation.theme.colorWhite
import com.gaurav.funapplication.presentation.theme.componentShapes

/**
 * Normal Text Component
 */
@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

/**
 * Header Component
 */
@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

/**
 * Text Field Component
 */
@Composable
fun MyTextFieldComponent(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        label = {
            Text(
                text = labelValue,
                color = colorText,
                fontSize = 14.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "first name"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = colorText,
            focusedLabelColor = colorText,
            cursorColor = colorText,
            focusedContainerColor = bgColor,
            unfocusedContainerColor = bgColor
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        isError = !errorStatus
    )
}


/**
 * Password Field Component
 */
@Composable
fun MyPasswordFieldComponent(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        value = passwordValue.value,
        onValueChange = {
            passwordValue.value = it
            onTextSelected(it)
        },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "first name"
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = colorText,
            focusedLabelColor = colorText,
            cursorColor = colorText,
            focusedContainerColor = bgColor,
            unfocusedContainerColor = bgColor
        ),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        trailingIcon = {
            val iconImage = if (passwordVisibility.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisibility.value) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus

    )
}

/**
 * Checkbox Component
 */
@Composable
fun CheckBoxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkState = remember { mutableStateOf(false) }
        Checkbox(
            checked = checkState.value,
            onCheckedChange = {
                checkState.value = it
                onCheckChanged.invoke(it)
            })
        ClickableTextComponent(value = value, onTextSelected)
    }
}

/**
 * Clickable Text Component
 */
@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "By continuing you accept to our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsText = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = termsText, annotation = termsText)
            append(termsText)
        }
    }
    ClickableText(
        text = annotatedString,
        style = TextStyle(fontSize = 14.sp),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "${span}")
                    if ((span.item == termsText) || (span.item == privacyPolicyText)) {
                        onTextSelected(span.item)
                    }
                }
        }

    )
}

/**
 * Button Component
 */
@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnable: Boolean = false) {
    Button(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp),
        enabled = isEnable
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(colorSecondary, colorPrimary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

/**
 * Divider Component
 */
@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

        HorizontalDivider(
            color = colorGray,
            thickness = 1.dp,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )

        Text(
            text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = colorText,
            fontWeight = FontWeight.Bold
        )

        HorizontalDivider(
            color = colorGray,
            thickness = 1.dp,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}

/**
 * Clickable Text Component
 */
@Composable
fun ClickableLoginTextComponent(isTryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (isTryingToLogin) stringResource(R.string.already_account) else stringResource(R.string.do_not_have_account)
    val loginText =
        if (isTryingToLogin) stringResource(R.string.login) else stringResource(R.string.register)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorPrimary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        text = annotatedString,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "${span}")
                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }
        }

    )
}

/**
 * Underline Text Component
 */
@Composable
fun UnderlineTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

/**
 * App Tool Bar Component
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    toolbarTitle: String,
    logoutButtonClicked: () -> Unit,
    navigationMenuClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = toolbarTitle, color = Color.White, fontSize = 20.sp) },
        navigationIcon = {
            IconButton(onClick = { navigationMenuClick.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(R.string.menu),
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = {
                logoutButtonClicked()
            }) {
                Icon(
                    imageVector = Icons.Filled.Logout,
                    contentDescription = stringResource(R.string.logout),
                    tint = colorWhite
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorPrimary, // Toolbar background color
            titleContentColor = Color.White // Title text color
        )
    )
}

/**
 * Navigation Drawer Header
 */
@Composable
fun NavigationDrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 200.dp)
            .background(colorPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.ic_profile_pic),
            contentDescription = "Profile Pic",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        NavigationText("Gaurav Kumar", 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        NavigationText("i.gauravKumar@gmail.com", 14.sp)
    }
}

/**
 * Navigation Drawer Body
 */
@Composable
fun NavigationDrawerBody(
    navigationItems: List<NavigationItems>,
    onNavigationItemClicked: (NavigationItems) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(navigationItems) {
            NavigationItemRow(it, onNavigationItemClicked)
        }
    }
}

/**
 * Navigation Item Row
 */
@Composable
fun NavigationItemRow(item: NavigationItems, onNavigationItemClicked: (NavigationItems) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNavigationItemClicked.invoke(item)
            }
            .padding(20.dp)
    ) {
        Icon(imageVector = item.icon, contentDescription = item.description)
        Spacer(modifier = Modifier.widthIn(18.dp))
        NavigationText(item.title, 18.sp)
    }
}

/**
 * Navigation Item's Text Component
 */
@Composable
fun NavigationText(title: String, textUnit: TextUnit) {
    val shadowOffset = Offset(4f, 5f)
    Text(
        text = title,
        style = TextStyle(
            fontSize = textUnit,
            fontWeight = FontWeight.Bold,
            color = colorText,
            shadow = Shadow(
                color = colorPrimary,
                offset = shadowOffset,
                blurRadius = 2f
            )
        )
    )
}
