import React from 'react';
import {Link} from "react-router-dom";

const productTerm =(props)=>
{
    return(
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author.name}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>

            <td scope={"col"} className={"text-right"}>
                    <a className={"btn btn-danger"} title={"Delete"}
                    onClick={()=>props.onDelete(props.term.id)}>
                        Delete</a>
            </td>

            <td scope={"col"} className={"text-right"}>
                <a className={"btn btn-success"} title={"MarkAsTaken"}
                   onClick={()=>props.onMarkAsTaken(props.term.id)}>
                    Mark As Taken</a>
            </td>

            <Link className={"btn btn-info ml-80"}
                  onClick={()=>props.onEditBook(props.term.id)}
                  to={`/books/edit/${props.term.id}`}
            >Edit</Link>

        </tr>

    );
}
export default productTerm;