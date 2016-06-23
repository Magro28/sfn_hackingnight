var game = new Phaser.Game(800, 600, Phaser.CANVAS, 'phaser-example', {
    preload: preload,
    create: create,
    update: update,
    render: render
});

function preload() {

    game.stage.backgroundColor = '#000070';

    game.load.tilemap('level1', 'app/map/level1.json', null, Phaser.Tilemap.TILED_JSON);
    game.load.image('tiles-1', 'app/map/tiles-1.png');

    game.load.spritesheet('player', 'app/img/gripe.run.png', 32, 32, 16);
}

var cursors;
var player;
var map;
var layer;
var facing;

function create() {
    game.physics.startSystem(Phaser.Physics.ARCADE);
    game.physics.arcade.gravity.y = 250;

    map = game.add.tilemap('level1');
    map.addTilesetImage('tiles-1');
    map.setCollisionByExclusion([44, 45, 46, 10, 11, 12, 13, 14, 15, 16, 47, 48, 49, 50, 51]);

    layer = map.createLayer('Tile Layer 1');
    layer.resizeWorld();

    player = game.add.sprite(0, 800, 'player', 1);
    player.smoothed = false;

    player.animations.add('right', [0, 1, 2, 3, 4, 5, 6, 7], 10, true);
    player.animations.add('left', [8, 9, 10, 11, 12, 13, 14, 15], 10, true);
    game.physics.enable(player, Phaser.Physics.ARCADE);

    player.body.bounce.y = 0;
    player.body.collideWorldBounds = true;
    //player.body.setSize(20, 32, 5, 16);

    game.camera.follow(player);

    cursors = game.input.keyboard.createCursorKeys();

}


function update() {


    game.physics.arcade.collide(player, layer);


    player.body.velocity.x = 0;

    if (cursors.up.isDown && player.body.onFloor()) {
        player.body.velocity.y = -150;
    }
    else if (cursors.down.isDown) {
        player.body.velocity.y = 150;
    }

    if (cursors.left.isDown) {


            if (facing != 'left') {
                player.animations.play('left');
                facing = 'left';
            }

        player.body.velocity.x = -150;

    }
    else if (cursors.right.isDown) {

            if (facing != 'right') {
                player.animations.play('right');
                facing = 'right';
            }

        player.body.velocity.x = +150;

    } else {
        if (facing != 'idle') {
            player.animations.stop();

            if (facing == 'left') {
                player.frame = 0;
            }
            else {
                player.frame = 5;
            }

            facing = 'idle';
        }
    }
}

function render() {


    //game.debug.cameraInfo(game.camera, 32, 32);

}
