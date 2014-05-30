# FontableTextView #

This is a project for easy changing TextView's (and some of its Subclasses) font to custom, loaded from assets.

## How to use ##

Instead of using TextView widget in xml use:

```
#!xml

<com.krossovochkin.fontabletextview.FontableTextView
            android:text="@string/hello_world"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            custom:typeface="roboto_bold" />
```
custom:typeface is an enum value, defined in the attr.xml file in the lib.

```
#!xml

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
#!xml

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
#!java

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FontManager.init(this);

    setContentView(R.layout.activity_main);
}
```

You can look at the demo project for more information.