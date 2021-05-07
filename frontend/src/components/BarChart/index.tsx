import { useEffect, useState } from "react"
import axios from "axios"
import Chart from "react-apexcharts"
import { BASE_URL } from "utils/requests"
import { SaleSuccess } from "types/sale"
import { round } from "utils/format"

type SeriesData = {
  name: string
  data: number[]
}

type ChartData = {
  labels: {
    categories: string[]
  }
  series: SeriesData[]
}

function BarChart() {
  const [chartData, setChartData] = useState<ChartData>({ labels: { categories: [] }, series: [] })

  function successRate(visited: number, deals: number) {
    return round(deals * 100.0 / visited, 1)
  }

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`).then((res) => {
      const data = res.data.reduce(
        (output: ChartData, curr: SaleSuccess) => {
          output.labels.categories.push(curr.sellerName)
          output.series[0].data.push(successRate(curr.visited, curr.deals))
          return output
        },
        {
          labels: { categories: [] },
          series: [
            {
              name: "% Sucesso",
              data: [],
            },
          ],
        }
      )
      setChartData(data)
    })
  }, [])

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },
  }

  return (
    <div>
      <Chart
        options={{ ...options, xaxis: chartData.labels }}
        series={chartData.series}
        type="bar"
        height="240"
      />
    </div>
  )
}

export default BarChart
