package com.example.constrain_layoff.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.constrain_layoff.ui.theme.Pink40
import com.example.constrain_layoff.ui.theme.Pink80
import com.example.constrain_layoff.ui.theme.Verdes

@Composable
fun PantallaCuadros(){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxTamaño = 50.dp
        val (boxRed, boxBlue, boxGreen, boxYell, boxCyan, boxMag, boxWhi, boxGrey, boxBla, boxPink, boxPurpul) = createRefs()

        Box(modifier = Modifier.size(boxTamaño).background(Color.Blue).constrainAs(boxBlue){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        Box(modifier = Modifier.size(boxTamaño).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxBlue.top, margin = 70.dp)
            start.linkTo(parent.start, margin = 70.dp)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Green).constrainAs(boxGreen){
            top.linkTo(boxBlue.top, margin = 70.dp)
            end.linkTo(parent.end, margin = 70.dp)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Yellow).constrainAs(boxYell){
            top.linkTo(boxRed.top, margin = 70.dp)
            start.linkTo(parent.start)
            end.linkTo(boxRed.end)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Cyan).constrainAs(boxCyan){
            top.linkTo(boxGreen.top, margin = 70.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Magenta).constrainAs(boxMag){
            top.linkTo(boxGreen.top, margin = 70.dp)
            start.linkTo(boxGreen.start)
            end.linkTo(parent.end)
        })

        Box(modifier = Modifier.height(200.dp).width(50.dp).background(Color.White).constrainAs(boxWhi){
            top.linkTo(boxYell.top, margin = 70.dp)
            start.linkTo(boxGreen.start)
            end.linkTo(parent.end)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Gray).constrainAs(boxGrey){
            top.linkTo(boxYell.top, margin = 70.dp)
            start.linkTo(parent.start)
            end.linkTo(boxRed.end)
        })

        Box(modifier = Modifier.size(boxTamaño).background(Color.Black).constrainAs(boxBla){
            top.linkTo(boxGrey.bottom, margin = 100.dp)
            start.linkTo(parent.start)
            end.linkTo(boxRed.end)
        })

        Box(modifier = Modifier.size(boxTamaño).background(color = Pink80).constrainAs(boxPink){
            top.linkTo(boxBla.top, margin = 70.dp)
            start.linkTo(parent.start, margin = 70.dp)
        })

        Box(modifier = Modifier.size(boxTamaño).background(color = Pink40).constrainAs(boxPurpul){
            top.linkTo(boxBla.top, margin = 70.dp)
            end.linkTo(parent.end, margin = 70.dp)
        })

    }
}
@Preview
@Composable
fun Previsualisacion(){
    PantallaCuadros()
}