
import {ToDo} from "../model/ToDo";
import {ToDoModell} from "./ToDoModell";
import './ToDoGallery.css';

type EditGalleryProps = {
    editGallery: ToDo
}
export default function EditGallery(props: EditGalleryProps) {

    return (
            <div>
               <p>ID: {props.editGallery.id}</p>
               <p>ID: {props.editGallery.description}</p>
               <p>ID: {props.editGallery.status}</p>
            </div>
    )

}