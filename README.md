# FontableTextView #

This is a project for easy changing TextView's (and some of its Subclasses) font to custom, loaded from assets.

## How to use ##

Instead of using TextView widget in xml use:

```
<com.krossovochkin.fontabletextview.FontableTextView
            android:text="@string/hello_world"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            custom:typeface="roboto_bold" />
```
custom:typeface is an enum value, defined in the attr.xml file in the lib.

```
<attr name="typeface" format="enum">
    <enum name="roboto_regular" value="0"/>
    <enum name="roboto_bold" value="1"/>
    <enum name="roboto_thin" value="2"/>
    <enum name="roboto_italic" value="3"/>
</attr>
```

You can customize it as you want, but there is one rule.
At the bottom of this attr.xml file there are string-array:

```
<string-array name="fontPaths">
    <item>Roboto-Regular</item>
    <item>Roboto-Bold</item>
    <item>Roboto-Thin</item>
    <item>Roboto-Italic</item>
</string-array>
```

Position in this string-array should correspond value in the 'typeface' enum.
This string-array is a fileName of a font.
So, 'Roboto-Regular' means there should be font file in: assets/fonts/Roboto-Regular.ttf.

Also, you should init FontManager in your activity **before** setContentView:

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FontManager.init(this);

    setContentView(R.layout.activity_main);
}
```

And there is cool thing: you can use in the java source code TextView instead of FontableTextView.
So, changing TextView's font affects only xml code and not java code. Useful

You can look at the demo project for more information.
