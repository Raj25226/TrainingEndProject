import '../../node_modules/bootstrap/dist/css/bootstrap.min.css';

const Input=(props)=>{

    return (
        <input type={props.type} name={props.name} id={props.id}  />
    );
}

export default Input;