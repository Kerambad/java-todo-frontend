import { useState } from "react";
import {ToDo} from "../model/ToDo";
import {ToDoModell} from "./ToDoModell";
import './ToDoGallery.css';

type ToDoGalleryProps = {
    toDoGallery: ToDo[]
}
export default function ToDoGallery(props: ToDoGalleryProps) {


    return (
        <div className={"todos"}>
            <div className={"todo"}>{props.toDoGallery.filter((element) => element.status === "OPEN").map((element) => <ToDoModell toDoModell={element} key={element.id}/>)}</div>
            <div className={"todo"}>{props.toDoGallery.filter((element) => element.status === "DOING").map((element) => <ToDoModell toDoModell={element} key={element.id}/>)}</div>
            <div className={"todo"}>{props.toDoGallery.filter((element) => element.status === "DONE").map((element) => <ToDoModell toDoModell={element} key={element.id}/>)}</div>
        </div>
    )

}