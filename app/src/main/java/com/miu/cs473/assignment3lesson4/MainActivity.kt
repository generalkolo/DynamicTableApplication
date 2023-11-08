package com.miu.cs473.assignment3lesson4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextVersion: EditText
    private lateinit var editTextCodeName: EditText
    private lateinit var addButton: Button
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        editTextVersion = findViewById(R.id.androidVersion)
        editTextCodeName = findViewById(R.id.androidVersionCode)
        addButton = findViewById(R.id.addBtn)
        tableLayout = findViewById(R.id.tableRow)

        // Add two static rows
        addStaticRow("Android 10", "Q")
        addStaticRow("Android 11", "R")

        addButton.setOnClickListener {
            val version = editTextVersion.text.toString()
            val codeName = editTextCodeName.text.toString()

            // Add a new row dynamically
            addDynamicRow(version, codeName)

            // Clear the input fields
            editTextVersion.text.clear()
            editTextCodeName.text.clear()
        }
    }

    private fun addStaticRow(version: String, codeName: String) {
        val row = TableRow(this)
        val rowParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        rowParams.setMargins(0, 0, 0, dpToPx(8)) // Add a margin of 8dp at the bottom of each row
        row.layoutParams = rowParams

        val versionTextView = TextView(this)
        versionTextView.text = version
        versionTextView.layoutParams =
            TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)

        val codeNameTextView = TextView(this)
        codeNameTextView.text = codeName
        codeNameTextView.layoutParams =
            TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)

        row.addView(versionTextView)
        row.addView(codeNameTextView)

        tableLayout.addView(row)
    }

    private fun addDynamicRow(version: String, codeName: String) {
        val row = TableRow(this)
        val rowParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT)
        rowParams.setMargins(0, 0, 0, dpToPx(8)) // Add a margin of 8dp at the bottom of each row
        row.layoutParams = rowParams

        val versionTextView = TextView(this)
        versionTextView.text = version
        versionTextView.layoutParams =
            TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)

        val codeNameTextView = TextView(this)
        codeNameTextView.text = codeName
        codeNameTextView.layoutParams =
            TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f)

        row.addView(versionTextView)
        row.addView(codeNameTextView)

        tableLayout.addView(row)
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }

}