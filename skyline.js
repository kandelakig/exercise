function skyline(city) {
  var cityLeftView = city.map(function(b, i) {
    return {
      left: b.left,
      height: b.height,
      right: b.right,
      no: i
    }
  })
  var cityHeightView = cityLeftView.slice(0).sort(function(a, b) {
    return b.height - a.height
  })

  var GROUND = {
    move: function() {
      var b = cityLeftView.slice(currentPosition.building.no+1).filter(function(element) {
        return element.left > currentPosition.building.right
      })[0]

      if (b) {
        return {
          x: b.left,
          y: 0,
          building: b,
          surface: LEFT,

        }
      } else {
        return null
      }
    },
    getCoordinate: function() {
      return 0
    }
  }

  var LEFT = {
    move: function() {
      return {
        x: currentPosition.x,
        y: currentPosition.building.height,
        building: currentPosition.building,
        surface: ROOF
      }
    },
    getCoordinate: function() {
      return currentPosition.x
    }
  }

  var ROOF = {
    move: function() {
      var b = cityLeftView.slice(currentPosition.building.no+1).filter(function(element) {
        return element.left > currentPosition.x &&
               element.left <= currentPosition.building.right &&
               element.height > currentPosition.y
      })[0]

      if (b) {
        return {
          x: b.left,
          y: currentPosition.y,
          building: b,
          surface: LEFT
        }
      } else {
        return {
          x: currentPosition.building.right,
          y: currentPosition.y,
          building: currentPosition.building,
          surface: RIGHT
        }
      }
    },
    getCoordinate: function() {
      return currentPosition.y
    }
  }

  var RIGHT = {
    move: function() {
      console.log("City #"+(currentPosition.building.no+1)+" at index of: "+ cityHeightView.indexOf(currentPosition.building))
      var b = cityHeightView.slice(cityHeightView.indexOf(currentPosition.building)).filter(function(element) {
        return element.left <= currentPosition.x &&
               element.right > currentPosition.x
      })[0]

      if (b) {
        return {
          x: currentPosition.x,
          y: b.height,
          building: b,
          surface: ROOF
        }
      } else {
        return {
          x: currentPosition.x,
          y: 0,
          building: currentPosition.building,
          surface: GROUND
        }
      }
    },
    getCoordinate: function() {
      return currentPosition.x
    }
  }

  var currentPosition = {
    x: 0,
    y: 0,
    building: {
      left: 0,
      height: 0,
      right: 0,
      no: -1
    },
    surface: GROUND
  }

  var result = [];

  while ((currentPosition = currentPosition.surface.move()) != null) {
    result.push(currentPosition.surface.getCoordinate())
  }

  return result
}

console.log(skyline([{left: 1, height: 11, right: 5}
,{left: 2, height: 6, right: 7}
,{left: 3, height: 13, right: 9}
,{left: 12, height: 7, right: 16}
,{left: 14, height: 3, right: 25}
,{left: 19, height: 18, right: 22}
,{left: 23, height: 13, right: 29}
,{left: 24, height: 4, right: 28}]))
