package com.example.constrain_layoff.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun PantallaCuadros(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxGreen) = createRefs()

        Box(modifier = Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(boxBlue.end)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Blue).constrainAs(boxBlue){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(100.dp).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

    }
}
@Preview
@Composable
fun Previsualisacion(){
    PantallaCuadros()
}