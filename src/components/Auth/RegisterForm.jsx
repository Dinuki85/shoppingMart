import { Button, MenuItem, Select, TextField, Typography } from '@mui/material'
import { Field, Form, Formik } from 'formik'
import React from 'react'
import { useNavigate } from 'react-router-dom'

const initialValue = {
    fullName: "",
    email: "",
    password: "",
    role: "ROLE_CUSTOMER",
}

export const RegisterForm = () => {
    const handleSubmit = (values) => {
        console.log("Form values", values)

    }
    const navigate = useNavigate()
    return (
        <div >
            <Typography variant='h5' className='text-center'>
                Register

            </Typography>

            <Formik onSubmit={handleSubmit} initialValues={initialValue}>
                <Form>
                    <Field
                        as={TextField}
                        name="fullName"
                        label="full name"
                        fullWidth
                        variant="outlined"
                        margin="normal"

                    />
                    <Field
                        as={TextField}
                        name="email"
                        label="email"
                        fullWidth
                        variant="outlined"
                        margin="normal"

                    />
                    <Field
                        as={TextField}
                        name="password"
                        label="password"
                        fullWidth
                        variant="outlined"
                        margin="normal"

                    />

                    <Field
                        fullWidth
                        margin="normal"
                        as={Select}
                        labelId="role-simple-select-label"
                        id="role-simple-select"
                        name="role"

                    //onChange={handleChange}
                    >
                        <MenuItem value={"ROLE_CUSTOMER"}>Customer</MenuItem>
                        <MenuItem value={"ROLE_SHOP_OWNER"}>Shop Owner</MenuItem>
                    </Field>

                    <Button sx={{ mt: 2, padding: "1rem" }} fullWidth type='submit' variant="outlined">Register</Button>


                </Form>


            </Formik>

            <Typography variant='body2' align='center' sx={{ mt: 3 }}>
                Already Have an Account?
                <Button size='small' onClick={() => navigate("/account/login")}>
                    Login
                </Button>


            </Typography>


        </div >
    )
}
