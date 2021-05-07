import { useEffect, useState } from "react"
import axios from "axios"
import Chart from "react-apexcharts"
import { BASE_URL } from "utils/requests"
import { SaleSum } from "types/sale"

type ChartData = {
  labels: string[]
  series: number[]
}

function DonutChart() {
  const [chartData, setChartData] = useState<ChartData>({labels:[], series: []})

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`)
    .then(res => {
      const data: ChartData = res.data.reduce((output: ChartData, curr: SaleSum) => {
        output.labels.push(curr.sellerName)
        output.series.push(curr.sum)
        return output
      },{labels:[], series: []})
      
      setChartData(data)
    })
  }, [])

  const options = {
    legend: {
      show: true,
    },
  }

  return (
    <div>
      <Chart
        options={{ ...options, labels: chartData.labels }}
        series={chartData.series}
        type="donut"
        height="240"
      />
    </div>
  )
}

export default DonutChart
