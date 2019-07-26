package nl.rptx.yakusokugeiko.repositories

import android.content.res.Resources
import com.google.gson.Gson
import nl.rptx.yakusokugeiko.R
import nl.rptx.yakusokugeiko.Techniques
import java.io.InputStream
import java.io.InputStreamReader

fun readTechniques(resources: Resources): Techniques =
    with(resources) { openRawResource(R.raw.techniques).use(readInputStream) }

private val readJson = fun(inputStreamReader: InputStreamReader): Techniques =
    Gson().fromJson(inputStreamReader, Techniques::class.java)

private val readInputStream = fun(inputStream: InputStream): Techniques =
    with(InputStreamReader(inputStream), { use(readJson) } )