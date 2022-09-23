import {ToDo} from "../model/ToDo";
import './ToDoModell.css';
import {changeStatus, putRequest} from "../Requests";

type ToDoModellProps = {
    toDoModell: ToDo;
}

export function ToDoModell(props: ToDoModellProps) {
    const buttontext = "hallo"
    return (
        <div className="todo-model">
            <p>ToDo: {props.toDoModell.description}</p>
            <p>Status: {props.toDoModell.status}</p>
            <p className={"buttons"}>
                <button>Details</button>
                <button>Edit</button>
                <button onClick={() => changeStatus(props.toDoModell)}>{buttontext}</button>
            </p>
            {/*<button>{() => {*/}
            {/*    if(props.toDoModell.status === "DONE") return "Delete";*/}
            {/*    else return "Advance"*/}
            {/*}}</button>*/}
        </div>
    );


    // const buttontext1:string = function () {
    //     if (props.toDoModell.status === "DONE") return "Delete";
    //     else return "Advance";
    // }


}