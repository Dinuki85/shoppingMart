import { Box } from '@mui/material';
import Modal from '@mui/material/Modal'
import React from 'react'
import { useLocation, useNavigate } from 'react-router-dom'
import { style } from '../Cart/Cart';

export const Auth = () => {
    const location = useLocation();
    const navigate = useNavigate();

    const handleOnClose = () => {
    navigate("/")
    }
  return (
    <>
        <Modal onClose ={handleOnClose} open ={
            location.pathname === '/account/register'||
            location.pathname ==='/account/login'
            
        }>
            <Box sx={style}>
                Hello

            </Box>


            
        </Modal>




    </>
  )
}
