# custom-rounded-shapes
Custom Rounded Shapes

Links:
- https://medium.com/@Zielony/clipping-and-shadows-on-android-e702a0d96bd4
- https://medium.com/better-programming/practical-image-porterduff-mode-usage-in-android-3b4b5d2e8f5f

###  com.google.android.material:material:1.0.0

~~~
class MaterialOldVariantFragment : Fragment(R.layout.fragment_material_old_variant) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radius = resources.getDimensionPixelSize(R.dimen.radius)
        val mainView = view.findViewById<LinearLayout>(R.id.mainView)

        val shapePathModel = ShapePathModel().apply {
            setAllCorners(RoundedCornerTreatment(radius.toFloat()))
            setAllEdges(TriangleEdgeTreatment(radius.toFloat(), true))
        }

        val backgroundDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
            paintStyle = Paint.Style.FILL
            isShadowEnabled = true
        }

        backgroundDrawable.setShadowColor(Color.RED)
        mainView.background = backgroundDrawable
    }
}
~~~

~~~
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    tools:context=".OutlineWidgetVariantFragment">

    <LinearLayout
        android:id="@+id/mainView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:orientation="horizontal"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:textAppearance="@style/TextAppearance.AppCompat.Caption"
            android:textColor="@android:color/white"
            android:text="@string/lorem_ipsum" />

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
~~~
