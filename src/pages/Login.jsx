import { useDispatch, useSelector } from "react-redux";
import { deleteUser, updateUser } from "../slices/loginSlice";

export default function Login() {
  const user = useSelector((state) => state.login);
  const dispatch = useDispatch();
  console.log(user);

  return (
    <>
      <div>
      <h1>Login page {user.user}</h1>
      <div className="d-flex justify-content-center gap-2">

      <button className="btn btn-primary"onClick={() => dispatch(updateUser("vanguards"))}>Login</button>
      <button className="btn btn-danger"onClick={() => dispatch(deleteUser("none"))}>Logout</button>
      </div>
      </div>
    </>
  );
}
