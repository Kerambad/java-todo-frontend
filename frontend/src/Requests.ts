import axios from "axios";
import {ToDo} from "./model/ToDo";
import App from "./App";

//Put Request
export function putRequest (prop: ToDo) {
        axios.put("/api/todo/" + prop.id, prop)
}
export function changeStatus (prop:ToDo) {
    if(prop.status === "OPEN") putRequest({id: prop.id, description: prop.description, status: "DOING"});
    else if(prop.status === "DOING") putRequest({id: prop.id, description: prop.description, status: "DONE"});
    else axios.delete("/api/todo/" + prop.id)
}

