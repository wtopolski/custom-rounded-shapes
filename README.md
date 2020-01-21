# Custom Rounded Shapes

## ViewOutlineProvider

### Clip

"Clipping means restricting the drawing of a view’s content to a specific shape ... If the clipped view is a layout then clipping is also applied to its children ... Starting with Android Lollipop there’s a native way of clipping views using view outlines. This method is hardware accelerated, very fast, pretty easy to use, correctly clips the layout’s content and produces antialiased outlines."

"Outlines aren’t just used for shadows, but by default they define the clipping of the view too! ... when the Outline you provide has canClip() returning true, which is the case when the outline is a rectangle, a rounded rectangle, or a circle. Non-round ovals, and arbitrary paths, are not able to provide clipping"

"Outlines represent the outer shape of a graphics object and define the ripple area for touch feedback."

"ViewOutlineProvider can’t clip to shapes other than rectangles, rounded rectangles and circles." Custom paths (even convex ones) are not suported. [1] ... "There’s a small difference in supported shapes when drawing shadows, the outline can be any convex shape, so it’s possible to use custom paths. This leads to weird situations where you can get nice shadows for diagonally cut views, but you have to clip them using a different method."

### Shadow

![shadow from 5](https://miro.medium.com/max/1000/1*nFcOfSdcmwflAnboYVGqyg.gif)

"The shadow here does not just adapt to different elevation values, but is also translated around and gets a larger or smaller size than the view itself." [4]

"The only limitation is that the shape must be convex. There are convenience methods on Outline to have ellipses, rectangles and rounded rectangles, but you could also use any arbitrary Path, as long as it’s convex."

"Outline is providing the required information for a Material sheet to project a shadow. The default behaviour for Views is to delegate the outline definition to their background drawable. ShapeDrawables for example provide outlines that match their shapes, while ColorDrawables, BitmapDrawables, etc. provide a rectangle matching their bounds."
