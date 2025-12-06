import { Grid } from '@mui/material'
import React from 'react'

const ShopDetail = () => {
    return (
        <div className='px-5 lg:px-20'>
            <section>
                <h3>Home/Sri Lanka/Grocery Items/3</h3>
                <div>
                    <Grid containre spacing={2}>
                        <Grid item xs={12} lg={6}>
                            <img className='w-full h-[40vh]
                             object-cover' src="https://www.pexels.com/photo/
                             assorted-vegetable-lot-2733918/"
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