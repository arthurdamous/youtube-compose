package dev.arthurdamous.youtubecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.arthurdamous.youtubecompose.ui.theme.YoutubeComposeTheme

val listOfVideos = listOf(
    Videos(
        title = "FLYING OVER RUSSIA (4K UHD) - Relaxing Music Along With Beautiful Nature Videos - 4K Video Ultra HD",
        thumbnailId = R.drawable.thumbnail_3,
        thumbnailProfileId = R.drawable.post1
    ),
    Videos(
        title = "FLYING OVER ENGLAND (4K UHD) - Calming Music With Stunning Natural Landscape Videos (Ultra HD)",
        thumbnailId = R.drawable.thumbnail_2,
        thumbnailProfileId = R.drawable.post2
    ),
    Videos(
        title = "Nature 4K Relaxation Film | Mediation Relaxing Music | Nature Sounds",
        thumbnailId = R.drawable.thumbnail_1,
        thumbnailProfileId = R.drawable.post3
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        VideoItem()
                        InfoVideo()
                        Divider()
                        Spacer(modifier = Modifier.height(6.dp))
                        InfoChannel()
                        Spacer(modifier = Modifier.height(6.dp))
                        Divider()
                        Spacer(modifier = Modifier.height(6.dp))
                        CommentsSection()
                        Spacer(modifier = Modifier.height(10.dp))
                        LazyColumn() {
                            items(listOfVideos.size) { i ->
                                ThumbnailVideo(
                                    thumbnailImage = listOfVideos[i].thumbnailId,
                                    stringTitle = listOfVideos[i].title,
                                    photoOfProfile = listOfVideos[i].thumbnailProfileId
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VideoItem() {

    var showButtons by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.29f)
            .clickable {
                showButtons = !showButtons
            }
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.thumbnail_1),
                contentDescription = "Video"
            )
        }

        if (showButtons) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        color = Color(red = 0f, blue = 0f, green = 0f, alpha = 0.6f)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .weight(0.7f)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            tint = Color.White,
                            contentDescription = "Minimize"
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.ic_cast),
                        tint = Color.White,
                        contentDescription = "cast",
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(end = 15.dp)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_caption),
                        tint = Color.White,
                        contentDescription = "cc",
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(end = 10.dp)
                    )
                    Icon(
                        imageVector = Icons.Outlined.Settings,
                        tint = Color.White,
                        contentDescription = "Settings",
                        modifier = Modifier
                            .weight(0.1f)
                            .padding(end = 10.dp)
                    )

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = Color.White,
                        contentDescription = "back",
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(100.dp),
                                color = Color(red = 0f, blue = 0f, green = 0f, alpha = 0.6f)
                            )
                            .padding(10.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        tint = Color.White,
                        contentDescription = "play",
                        modifier = Modifier
                            .background(
                                color = Color(red = 0f, blue = 0f, green = 0f, alpha = 0.6f),
                                shape = RoundedCornerShape(100.dp)
                            )
                            .padding(14.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        tint = Color.White,
                        contentDescription = "foward",
                        modifier = Modifier
                            .background(
                                color = Color(red = 0f, blue = 0f, green = 0f, alpha = 0.6f),
                                shape = RoundedCornerShape(100.dp)
                            )
                            .padding(10.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "0:01 / 5:14",
                                style = MaterialTheme.typography.body1,
                                color = Color.White
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_fullscreen),
                                contentDescription = "fullscreen",
                                tint = Color.White
                            )
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center

                        ) {

                            LinearProgressIndicator(
                                progress = 0.2f,
                                color = Color.Gray,
                                backgroundColor = Color(
                                    red = 0f,
                                    blue = 0f,
                                    green = 0f,
                                    alpha = 0.4f
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_circle),
                                    contentDescription = "pointer",
                                    tint = Color.Red,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                        }
                    }
                }
            }
        }


    }

}

@Composable
fun InfoVideo() {

    var isLiked by remember {
        mutableStateOf(false)
    }
    val scroll = rememberScrollState(0)

    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 4.dp, start = 10.dp)
                    .clickable { },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "COSTA RICA IN 4K 60fps HDR (ULTRA HD)",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h2,
                    fontFamily = FontFamily.Default,
                    modifier = Modifier.weight(0.9f)
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "description",
                    modifier = Modifier.weight(0.1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 6.dp)
            ) {
                Text(
                    text = "217M views - 4y ago",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .horizontalScroll(scroll),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = if (isLiked) R.drawable.ic_thumb_up_out else R.drawable.ic_thumbsup),
                        contentDescription = "thumbsup",
                        modifier = Modifier.clickable { isLiked = !isLiked }
                    )
                    Text(text = "Like")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_thumb_down),
                        contentDescription = "thumbsdown"
                    )
                    Text(text = "Dislike")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_share_24),
                        contentDescription = "share"
                    )
                    Text(text = "Share")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_outline_download_24),
                        contentDescription = "download"
                    )
                    Text(text = "Download")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_save),
                        contentDescription = "save"
                    )
                    Text(text = "Save")
                }
            }
        }
    }
}

@Composable
fun InfoChannel() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(0.1f)) {
                Image(
                    painter = painterResource(id = R.drawable.photo3),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop,
                    contentDescription = "channelPhoto",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(
                            RoundedCornerShape(100.dp)
                        )
                        .background(
                            shape = RoundedCornerShape(100.dp),
                            color = Color.Transparent
                        )
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(0.6f)
            ) {
                Text(
                    text = "Videos from Internet",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                )
                Text(
                    text = "723K Subscribers",
                    fontSize = 14.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(0.3f)
            ) {
                Text(
                    text = "SUBSCRIBE",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.youtube_red)
                )
            }
        }
    }
}

@Composable
fun ThumbnailVideo(
    thumbnailImage: Int,
    stringTitle: String,
    photoOfProfile: Int
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { }) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = thumbnailImage),
                    contentDescription = "thumbnail",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit
                )
                Text(
                    text = "5:47:31",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    color = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color.Black
                        )
                        .align(alignment = Alignment.BottomEnd)
                        .padding(4.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.weight(0.1f)) {
                    Image(
                        painter = painterResource(id = photoOfProfile),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        contentDescription = "channelPhoto",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(
                                RoundedCornerShape(100.dp)
                            )
                            .background(
                                shape = RoundedCornerShape(100.dp),
                                color = Color.Transparent
                            )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .weight(0.8f)
                        .padding(start = 2.dp)
                ) {
                    Text(
                        text = stringTitle,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,
                        fontStyle = FontStyle.Normal
                    )
                    Text(
                        text = "PRIMAL EARTH - 25K views - 5 months ago",
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        maxLines = 1,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.weight(0.1f)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = "more",
                        Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CommentsSection() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = "Comments"
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "23K",
                        color = Color.Gray
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_expando),
                    contentDescription = "expand"
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.padding(end = 6.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.photo3),
                        contentDescription = "comment",
                        modifier = Modifier
                            .clip(RoundedCornerShape(100.dp))
                            .size(24.dp)
                    )
                }
                Text(
                    text = "Hi guys, check my other videos",
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    YoutubeComposeTheme {
        Column {
            VideoItem()
            InfoVideo()
            Divider()
            Spacer(modifier = Modifier.height(6.dp))
            InfoChannel()
            Spacer(modifier = Modifier.height(6.dp))
            Divider()
            Spacer(modifier = Modifier.height(6.dp))
            CommentsSection()
            Spacer(modifier = Modifier.height(10.dp))
            ThumbnailVideo(
                stringTitle = "FLYING OVER RUSSIA (4K UHD) - Relaxing Music Along With Beautiful Nature Videos - 4K Video Ultra HD",
                thumbnailImage = R.drawable.thumbnail_3,
                photoOfProfile = R.drawable.post1
            )
        }
    }
}