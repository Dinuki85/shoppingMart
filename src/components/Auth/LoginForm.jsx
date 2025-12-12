import { TextField, Typography } from '@mui/material'
import { Field, Form, Formik } from 'formik'
import React from 'react'



const initialValue = {
  emai: "",
  password: ""
}
export const LoginForm = () => {
  const handleSubmit = () => {

  }
  return (
    <div >
      <Typography variant='h5' className='text-ceneter'>
        Login

      </Typography>

      <Formik onSubmit={handleSubmit} initialValue={initialValue}>
        <Form>
          <Field
            as={TextField}
            name="email"
            label="email"
            fullWidth
            variant="outlined"

          />
          <Field
            as={TextField}
            name="password"
            label="password"
            fullWidth
            variant="outlined"

          />


        </Form>


      </Formik>
    </div>
  )
}
