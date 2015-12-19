import bpy

tiles = []

for obj in bpy.data.objects:
    if obj.name.startswith("refcube"):
        tiles.append(obj)

for curObj in  tiles:
    prevLoc = curObj.location.copy()
    curObj.hide_render = False
    
    for otherObj in tiles:
        if curObj != otherObj:
           otherObj.hide_render = True
    
    curObj.location = (0,0,0)
    bpy.data.scenes['Scene'].render.filepath = "D:\\Projects\\lis\\temp\\" + curObj.name + ".png"
    bpy.ops.render.render(write_still = True)
    
    curObj.hide_render = True
    curObj.location = prevLoc