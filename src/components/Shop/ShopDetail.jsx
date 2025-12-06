import { Grid } from '@mui/material'
import React from 'react'

const ShopDetail = () => {
    return (
        <div className='px-5 lg:px-20'>
            <section>
                <h3 className='mb-4 font-serif font-semibold'>Home/Sri Lanka/Grocery Items/3</h3>
                <div>
                    <Grid container spacing={2}>
                        <Grid item xs={12} >
                            <img 
                                src="https://images.pexels.com/photos/264636/pexels-photo-264636.jpeg"
                                alt=""
                                style={{
                                    width: '100%',
                                    height:'40vh',
                                    objectFit:'cover',
                                    display:'block'
                                 
                                }}
                               
                            />
                        </Grid>
                        
                        <Grid item xs={12} lg={6}>
                            <img className="w-full h-[40vh] object-cover rounded-md"
                                src="https://images.pexels.com/photos/5473023/pexels-photo-5473023.jpeg"
                                alt=""
                               style={{
                                    width: '100%',
                                    height:'40vh',
                                    objectFit:'cover',
                                    display:'block'
                                 
                                }}
                            />
                        </Grid>
                        <Grid item xs={12} lg={6}>
                            <img className="w-full h-[40vh] object-cover rounded-md"
                                src="https://images.pexels.com/photos/2733918/pexels-photo-2733918.jpeg"
                                alt=""
                               style={{
                                    width: '100%',
                                    height:'40vh',
                                    objectFit:'cover',
                                    display:'block'
                                 
                                }}
                            />
                        </Grid>
                       

                    </Grid>
                </div>
            </section>
        </div>


    )
}

export default ShopDetail