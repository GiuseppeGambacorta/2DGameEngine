```mermaid
classDiagram

class GameEngine {
  <<class>>
  -period: long
  -logger: Logger
  -scenes: List<Scene>
  -currentScene: Scene
  -window: wiev
  +GameEngine()
  +mainLoop(): void
  -waitForNextFrame(current: long): void
  -processInput(): void
  -updateGame(elapsed: int): void
  -render(): void
}
class P2d {
  <<class>>
  -x: double
  -y: double
  +P2d(x: double, y: double)
  +getX(): double
  +getY(): double
  +sum(v: V2d): P2d
  +sub(v: P2d): V2d
}
class V2d {
  <<class>>
  -x: double
  -y: double
  +V2d(x: double, y: double)
  +getX(): double
  +getY(): double
  +sum(v: V2d): V2d
  +module(): double
  +getNormalized(): V2d
  +mul(fact: double): V2d
}
class wievimpl {
  <<class>>
  -frame: JFrame
  -panel: ScenePanel
  -scene: Scene
  +wievimpl(scene: Scene, gameName: String, weight: int, height: int)
  +render(): void
}
class ScenePanel {
  <<class>>
  +ScenePanel(weight: int, height: int)
}
class GameObjectImpl {
  <<class>>
  -pos: P2d
  -vel: V2d
  +GameObjectImpl(pos: P2d, vel: V2d)
  +setPos(pos: P2d): void
  +setVel(vel: V2d): void
  +updateState(dt: int): void
  +getCurrentPos(): P2d
  +getCurrentVel(): V2d
}
class Ball {
  <<class>>
  +Ball(pos: P2d, vel: V2d)
}

App --> GameEngine
GameEngine --> P2d
GameEngine --> V2d
GameEngine --> wievimpl
wievimpl --> ScenePanel
GameObjectImpl --> P2d
GameObjectImpl --> V2d
Ball --> GameObjectImpl