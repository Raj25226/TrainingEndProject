import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import NavBar from '../NavBar';

const Login=()=>{

    return <>
        <NavBar />
        <div class="form-floating mb-3">
            <input type="email" className="form-control" id="floatingInput" placeholder="name@example.com" />
            <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
            <input type="password" className="form-control" id="floatingPassword" placeholder="Password" />
            <label for="floatingPassword">Password</label>
        </div>
    </>
}

export default Login;