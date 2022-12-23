import React, { useState, useRef, useEffect } from "react";

function DragNDrop({ data }) {
  const [list, setList] = useState(data);
  const [dragging, setDragging] = useState(false);
  const [d] = useState(["Not Started", "In Progress", "Completed"]);
  useEffect(() => {
    setList(data);
  }, [setList, data]);

  const dragItem = useRef();
  const dragItemNode = useRef();

  const handletDragStart = (e, item) => {
    // console.log("Starting to drag", item);

    dragItemNode.current = e.target;
    dragItemNode.current.addEventListener("dragend", handleDragEnd);
    dragItem.current = item;

    setTimeout(() => {
      setDragging(true);
    }, 0);
  };
  const handleDragEnter = (e, targetItem) => {
    // console.log("Entering a drag target", targetItem);
    // console.log([dragItemNode.current, e.target]);
    if (dragItemNode.current !== e.target) {
      // console.log("Target is NOT the same as dragged item");
      setList((oldList) => {
        let newList = JSON.parse(JSON.stringify(oldList));
        newList[targetItem.grpI].items.splice(
          targetItem.itemI,
          0,
          newList[dragItem.current.grpI].items.splice(
            dragItem.current.itemI,
            1
          )[0]
        );
        dragItem.current = targetItem;
        localStorage.setItem("List", JSON.stringify(newList));
        // console.log(newList);
        return newList;
      });
    }
  };
  const sty = (e) => {
    if (e === "group 1") {
      return "red";
    } else if (e === "group 2") {
      return "yellow";
    } else if (e === "group 3") {
      return "green";
    }
  };
  const handleDragEnd = (e) => {
    setDragging(false);
    dragItem.current = null;
    dragItemNode.current.removeEventListener("dragend", handleDragEnd);
    dragItemNode.current = null;
  };
  const getStyles = (item) => {
    if (
      dragItem.current.grpI === item.grpI &&
      dragItem.current.itemI === item.itemI
    ) {
      return "dnd-item current";
    }
    return "dnd-item";
  };

  if (list) {
    var vx = 0;
    return (
      <div
        className="drag-n-drop row"
        style={{ margingLeft: "20%", marginTop: "20%" }}>
        {list.map((grp, grpI) => (
          <div
            key={grp.title}
            onDragEnter={
              dragging && !grp.items.length
                ? (e) => handleDragEnter(e, { grpI, itemI: 0 })
                : null
            }
            className="dnd-group col"
            style={{
              height: "70vh",
              width: "30vw",
              border: "2px solid blue",
              textAlign: "center",
              marginTop: "55%",
            }}>
            <h1 style={{ backgroundColor: "lightblue", color: "black" }}>
              {d[vx++]}
            </h1>
            {grp.items.map((item, itemI) => (
              <div
                draggable
                key={item}
                onDragStart={(e) => handletDragStart(e, { grpI, itemI })}
                onDragEnter={
                  dragging
                    ? (e) => {
                        handleDragEnter(e, { grpI, itemI });
                      }
                    : null
                }
                className={dragging ? getStyles({ grpI, itemI }) : "dnd-item"}
                style={{
                  background: sty(grp.title),
                  height: "10vh",
                  width: "20vw",
                  border: "2px solid black",
                  textAlign: "center",
                  marginLeft: "12%",
                }}>
                {item}
              </div>
            ))}
          </div>
        ))}
      </div>
    );
  } else {
    return null;
  }
}

export default DragNDrop;
