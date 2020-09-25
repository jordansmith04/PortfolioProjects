import React from 'react';
import { useForm } from 'react-hook-form';

export default function Login() {
  const { register, handleSubmit, errors } = useForm();
  const onSubmit = data => {
        preventDefault();
      console.log(data);
      axios.post('http://localhost:5000/users/add', data)
        .then(res => console.log(res.data));
  }
 
  
  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <input type="text" placeholder="Email" name="Email" ref={register({required: true, pattern: /^\S+@\S+$/i})} />
      <input type="text" placeholder="Password" name="Password" ref={register({required: true, min: 6, pattern: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/gm/i})} />

      <input type="submit" />
      <Link to="/register" className="btn btn-link">Register</Link>
    </form>
  );
}

