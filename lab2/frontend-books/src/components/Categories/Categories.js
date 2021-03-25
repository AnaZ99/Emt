import React from 'react' ;
import {Link} from 'react-router-dom';

const categoriess= (props)=>{
    return(
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Categories</th>

                        </tr>
                        </thead>
                        <tbody>
                        {props.kategorii.map((term)=>{
                            return(
                                <tr>
                                <td>{term}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>

            </div>

        </div>

    );
}

export default categoriess;