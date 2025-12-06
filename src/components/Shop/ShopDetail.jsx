import { Grid } from '@mui/material'
import React from 'react'

const ShopDetail = () => {
    return (
        <div className='px-5 lg:px-20'>
            <section>
                <h3 className='mb-4 font-serif font-semibold'>Home/Sri Lanka/Grocery Items/3</h3>
                <div>
                    <Grid container spacing={2}>
                        <Grid item xs={12}  >
                            <img className="object-cover w-full h-100"
                                src="https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg"
                                alt=""
                                
                               
                            />
                        </Grid>
                        
                        
                       

                    </Grid>
                </div>
            </section>
        </div>


    )
}

export default ShopDetail